package com.udacity.shoestore.ui

import android.app.Activity
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.inputmethod.InputMethodManager
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.udacity.shoestore.R
import com.udacity.shoestore.databinding.FragmentShoeDetailBinding
import com.udacity.shoestore.models.Shoe

class ShoeDetailFragment : Fragment() {

    private lateinit var binding: FragmentShoeDetailBinding

    private val viewModel: ShoeViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_shoe_detail, container, false)

        binding.shoe = Shoe()

        binding.cancelButton.setOnClickListener {
            findNavController().navigateUp()
        }

        binding.saveButton.setOnClickListener {
            hideKeyboard()
            if (validateInput()) {
                Toast.makeText(
                    context,
                    getString(R.string.shoe_details_missing),
                    Toast.LENGTH_SHORT
                )
                    .show()
            } else {
                viewModel.addShoe(binding.shoe!!)
                findNavController().navigateUp()
            }
        }

        return binding.root
    }

    private fun validateInput(): Boolean {
        return binding.shoeNameEditText.text.isEmpty()
                || binding.companyEditText.text.isEmpty()
                || binding.shoeSizeEditText.text.isEmpty()
                || binding.shoeSizeEditText.text.toString() == "0.0"
                || binding.descriptionEditText.text.isEmpty()
    }

    private fun hideKeyboard() {
        val imm = context?.getSystemService(Activity.INPUT_METHOD_SERVICE) as InputMethodManager
        imm.hideSoftInputFromWindow(view?.windowToken, 0)
    }
}