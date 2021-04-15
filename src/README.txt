Author: Daniel Ramirez
Purpose: Create a GUI Database

-------------------------Notes-----------------
// their is already a database inside so you don't need to import the database before.

// the best way i found to make the project work is to make a dummy project work space and the
just copy and paste the stuff so it works in eclipse after it was in the zip file other then that the project itself should work

-------find person menu---------
    -works as intended but i didn't get a chance to make it more flexible like if you want to search for freshman and sophomore
    you can't since i only allow you to search one at a time.

    -if you want to find all the people in the database then you leave first name and last name blank and put the data type to be "Person" and it will return everyone in the database
    this works for each data type so if you wan all Employees you do the same and for Students and Faculty and Staff each leaving their respective text fields blank as well.

    -then if you want to search through freshman or sophomore then  you leave everything else blank other then the class rank
    -same thing for th other fields depending on what you want to find or if you wan to use all available each works and if you don't find anything it will return with "no one found".

------Comparing menu--------

       -works as intended and the only thing i wanted to add to this was maybe change the check boxes to be a little bit different using CSS but i didn't have any time

       -i only allow you to checkbox at most 2 people and then the program will set the visibility to all other checkbox to be false to only force you to compare them

--------Add Person Menu---------

       -works as intended but for this i didnt add a new Phone type when you click the button to add a new Phone since i ran out of time but everything else work

       - you will first choose which type of person you would like to add then add the texts into the text fields and if you don't put a number into the zip code or phoneNumber or street/apartment number
       then it will add a label to tell you that the data type is wrong.

       - if you leave the text fields blank a label will appear telling you to fil in something and if the phone number format is wrong then the label wil switch to tel you that the format is wrong.

       - you can then use the find button to check that your person is added.

--------Delete Person Menu--------

       -works as intended but for some reason i was getting an error with index out of bounds and i assume its due to the fact that if you try to keep deleting people even though im not constantly updating it as you delete
       it then you aren't actually deleting a person that is in index 30 for example (if you delete someone from 28 and then try to delete someone from 29 then that person isn't 29 anymore rather they are the new 28 and
       i didn't have a chance to update it so i just used a try and catch and just let you keep deleting people )

       -so it will work if you just delete one person at a time and a label will pop out and tell you who you deleted. and if you choose to delete more the option is their but its not fully functional.

-------CSV File Menu--------

    -works as intended the one thing i didnt get to complete though was the requirement that it wanted you to output the database in the "entry format" i left it as a the same format as the
    previous homework

    -if you want to grab a file then you will be automatically started in the src location and then you go into the file to download a "People.csv" file and i only allow you to see files that are csv since that the only
    file that can read.

    - the output file works too and it will output the file in .txt format and it will show a label that your stuff is printed or read depending on the option that is selected.