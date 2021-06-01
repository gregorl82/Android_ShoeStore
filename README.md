# Shoe Store Inventory App

An application designed to record the inventory for a shoe store, that implements Jetpack Navigation, ViewModels and LiveData with data binding.

The app consists of five screens:

1. A login screen for the user to enter sign in credentials (note - this version of the app does not have authentication features).
2. A welcome screen that simulates a successful sign in.
3. A user guide page, detailing instructions on how to use the app.
4. A shoe list screen to display the list of shoes the user has added to the inventory.
5. A shoe detail screen for adding a new shoe to the inventory.

## Technical features
- single Activity application, uses a Fragment to represent each screen
- all views are inflated using data binding and fields are populated with bound data
- uses Jetpack Navigation to manage the flow of screens through the app and the back stack
- shoe list and new shoe entry screens use a shared ViewModel to save and display shoes
- shoe list is wrapped in a LiveData object
- shoe list screen observes the list of shoes and creates the shoe list when the list is updated by the shoe entry screen

## Ideas for further development

- Add an authentication layer to manage user access
- Add a persistence layer to store the added items between app uses
- Use RecyclerView for more performant display of the list of shoes
- Allow editing and deleting of existing list items
- Allow user to upload images for each shoe