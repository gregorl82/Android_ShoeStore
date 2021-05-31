package com.udacity.shoestore.ui

import android.os.Bundle
import android.view.*
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import com.udacity.shoestore.R
import com.udacity.shoestore.databinding.FragmentShoeListBinding
import kotlinx.android.synthetic.main.shoe_list_item.view.*

class ShoeListFragment : Fragment() {

    private lateinit var binding: FragmentShoeListBinding

    private val viewModel: ShoeViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_shoe_list, container, false)

        binding.fab.setOnClickListener {
            findNavController().navigate(R.id.action_shoeListFragment_to_shoeDetailFragment)
        }

        setHasOptionsMenu(true)

        viewModel.shoeList.observe(viewLifecycleOwner, Observer {

            if (it.isNotEmpty()) {
                binding.placeholderText.visibility = View.GONE

                it.forEach { shoe ->
                    val view = inflater.inflate(R.layout.shoe_list_item, container, false)
                    view.name_text.text = shoe.name
                    view.company_text.text = shoe.company
                    view.size_text.text = "Size: ${shoe.size}"
                    view.description_text.text = shoe.description

                    binding.shoesList.addView(view)
                }
            }
        })

        return binding.root
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)
        inflater.inflate(R.menu.shoe_list_menu, menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId == R.id.action_logout) {
            findNavController().navigate(R.id.action_shoeListFragment_to_loginFragment)
        }

        return super.onOptionsItemSelected(item)
    }
}