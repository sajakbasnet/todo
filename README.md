# Todo-Application
 It is an application for the user where the user can register themselves and login in the application add their todo according to the priority and date and set notification for the date and time when they need to be reminded. 
 
 <hr>
 
## Installation

### <b>1.Register User </b>
<p><i> - User should enter their username, email-address, and password for the registration.</i></p>

### <b>2.User Login </b>
<p><i> - User should enter their username and password for Login.</i></p>

### <b>3.Todo-list </b>
<p><i> - User will be able to see all the list after login and can add their todo by clicking in the floating Add icon button.</i></p>

### <b>4.Edit Todo </b>
<p><i> - User will be able to edit the todo by clicking on the Todo item.</i></p>

### <b>5.Delete Todo </b>
<p><i> - User will be able to delete the todo by swiping left or right from the list</i></p>

### <b>6.Todo by Priority </b>
<p><i> - User will be able to view todo item according to prioirty</i></p>

<hr>

### Clone
- Clone this repo to your local machine using 'https://github.com/sajakbasnet/todo/'

<hr>

## Architecture Design (MVVM)

## <B>MODEL</B>
### 1. Adapter
- pageAdapter
- TaskAdapter

### 2. Database
- AppDatabase
- DateConverter
- TaskDao
- TasEntry
- User
- UserDao
- UserDatabase

## <B>VIEW</B>
### 1. Activity
- MainActivity
- HomeActivity
- RegisterActivity
- AddEditTaskActivity

### 2. Fragments
- HomeFragment
- ListFragment
- UserFragment
- priority1fragment
- priority2fragment
- priority3fragment

## <B>VIEW MODEL</B>
- TaskActivityVieModel
- AddEditTaskViewModel
- TaskActivityVieModelp1
- TaskActivityVieModelp2
- TaskActivityVieModelp3

<hr>

## Features
- user login
- user description
- swipe feature
- calendar view
- time notification
- speech to text

<hr>

## Application Developemt 
- Master
- user_login branch
- user_description branch
- todo-list branch
- speech_to_text branch
- calendar_view brnach
- time_notification branch
- swipefeature branch

<hr>

<img src="![Screenshot](cricket.png)" height ="700" width="600"/>

## References for the project

All list of modules that has been used for completion of this project

<i>1. Defining data using Room entities : 'https://developer.android.com/training/data-storage/room/defining-data'</i>

<i>2. Entity : 'https://developer.android.com/reference/android/arch/persistence/room/Entity'</i>

<i>3. Accessing data using Room DAOs : 'https://developer.android.com/training/data-storage/room/accessing-data'</i>

<i>4. Database : 'https://developer.android.com/reference/android/arch/persistence/room/Database'</i>

<i>5. Write and View Logs with Logcat : 'https://developer.android.com/studio/debug/am-logcat'</i>

<i>6. Menus : 'https://developer.android.com/guide/topics/ui/menus'</i>

<i>7. Android: Navigation Drawer : 'https://medium.com/quick-code/android-navigation-drawer-e80f7fc2594f'</i>

<i>8. Create views into a database : 'https://developer.android.com/training/data-storage/room/creating-views'</i>

<i>9. Query : 'https://developer.android.com/reference/android/arch/persistence/room/Query'</i>

<i>10. Pass data between fragments : 'https://developer.android.com/training/basics/fragments/pass-data-between'</i>

<i>11. Calendar.Builder : 'https://developer.android.com/reference/java/util/Calendar.Builder'</i>

<i>12. Android Speech to Text Tutorial : 'https://www.simplifiedcoding.net/android-speech-to-text-tutorial/'</i>

<i>13. Widget : 'https://developer.android.com/reference/android/support/v7/widget/package-summary' </i>

<hr>


## License

[![License](http://img.shields.io/:license-mit-blue.svg?style=flat-square)](http://badges.mit-license.org)

- **[MIT license](http://opensource.org/licenses/mit-license.php)**
