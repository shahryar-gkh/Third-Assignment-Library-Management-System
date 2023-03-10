# **Third Assignment Report**
- Mohammad Golkhorshidi
- 401222117

## Introduction
- This assignment was about creating a library in java that users and librarians can access and do different things in. The main purpose of this project was learning how to code in OOP.
- In this assignment we had to learn the basics of OOP in java. Handling classes and their methods and also getting familiar with arraylists and hashmaps were the main objectives of this assignment.
- For completing this assignment, I had to learn OOP more profoundly to be able to use it on a large scale. I also had to collect some information on hashmaps and their related functions because it was a new concept for me.

## Design and Implementation
- The library has 5 classes. The book class that keeps some information on the books; including their title, author, etc. The user class that keeps the username, password, and a list of the books the user has borrowed but hasn't returned. The librarian class that only keeps the username and password. The library class which includes the main part of the OOP code and all the methods that change data related to the other 3 classes. And finally there's the main class that has the code related to the menu.
- Keeping the data of users, books and librarians was one of the most important parts of this project. I created an arraylist for those 3 classes in my library class and wrote the methods there using those arraylists. Then I created an object of the library class inside my main class and built the menu using that object. Also, for storing the number of copies left of each book, I created a hashmap with the key of the book's ISBN and the value of the number of the copies.
- Since this was a bigger assignment than I was used to, I had to keep an eye out for details that could ruin the code. I ran into many problems while I was building a menu and for most of them, I had to write whole new methods in my library class or change some of the ones I had written completely. Some methods needed a different return value, some needed more parameters, some needed changes in the loops, and the list goes on. Making my code clean was also an issue, but I tried learning a few ways online to make it as clean as it could get; using "for each" instead of the regular "for" was one of them.

## Testing and Evaluation
- In the process of writing the code for the menu, I had to run it many times to make sure I wasn't getting errors or making mistakes in my loops.
- There were two particular errors that I couldn't figure out the reason of for a long period of time. The first one was related to the first librarian being initialized twice which caused an issue in the menu. The second one had to do with the ISBN being initialized as an integer. The problem was that ISBNs always have 13 digits and the integer data type doesn't have enough memory for a numbers with 13 digits. So after figuring this out, I had to go back to all the lines I had used a book's ISBN and change the data type into long.

## Conclusion
- OOP is a very efficient way of coding and there's no "one right way" to complete a project in it. The things you can do through OOP are endless, and it gives you a lot of power in how you want to write your code.