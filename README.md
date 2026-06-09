# SimpleBot

A simple chatbot built using Java that can learn new information from the user and remember it even after the program is closed.

The project uses a HashMap to store knowledge during execution and a text file (`knowledge.txt`) to save the data permanently.

## Features

* Teach the chatbot new information
* Ask questions about learned topics
* Save knowledge automatically
* Load saved knowledge when the program starts
* View all stored knowledge
* Simple menu-driven interface

## Files

### Main.java

Handles the user interface and menu options.

### Brain.java

Contains the chatbot logic for learning, remembering, saving, and loading information.

### knowledge.txt

Stores all learned information in the format:

topic==information

## How to Run

Compile the files:

```bash
javac Main.java Brain.java
```

Run the program:

```bash
java Main
```

## Example

```text
---- MENU ----
1. Teach me something
2. Ask me a question
3. Show all I know
4. Exit
```

Teaching the bot:

```text
What's on your Mind Now!!!: what is java
What about it? : Java is a programming language.
```

Asking the bot:

```text
Your question: what is java
Answer: Java is a programming language.
```

## Concepts Used

* Java
* OOP (Object-Oriented Programming)
* HashMap
* File Handling
* Collections Framework

## Future Improvements

* Better question matching
* GUI version using Java Swing
* Database storage
* AI/NLP support

## Author

Hasth

A small Java project created for practicing Core Java concepts such as file handling, collections, and object-oriented programming.
