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


## License

[![License](http://img.shields.io/:license-mit-blue.svg?style=flat-square)](http://badges.mit-license.org)

- **[MIT license](http://opensource.org/licenses/mit-license.php)**
