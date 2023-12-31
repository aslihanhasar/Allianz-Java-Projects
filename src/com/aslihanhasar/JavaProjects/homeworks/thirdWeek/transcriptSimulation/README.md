# TRANSCRIPT MANAGEMENT SYSTEM

### The Transcript Management System is an application that allows clients to manage student transcript-related operations. It includes the following classes.

---

## PROJECT DETAILS

* Package util, contains the definition of the enum type Grade, and a test class for it,
  named GradeTest.

#### Grade (Enum) :

The Grade enum type represents student grades with constants A, B, C, D, and F.
Each constant has 'stringValue' (letter grade) and numericValue (numeric grade) fields.
The toString() method displays the letter and numerical grade for each constant.

#### GradeTest:

The GradeTest class is a test program for the Grade enum.
It uses a for loop and the values() method of Grade to print all the grades
along with their numeric values using the toString() method of the Grade class.

* Package main, contains the CourseGrade, Transcript and GenerateTranscript classes.

#### CourseGrade:

The CourseGrade class represents a student's course information.
It stores courseDepartment, courseCode, courseCredit, and gradeTaken.
The class ensures valid values with appropriate getters and setters.
It has four constructors for different inputs and a toString() method for formatted output.

#### Transcript:

The Transcript class stores a student's transcript with their studentID and a list of CourseGrade objects.
The GPA is calculated and stored for the transcript.

#### GenerateTranscript:
The GenerateTranscript class is responsible for generating student transcripts. 
It contains two methods:
takeInputFromUser():
It prompts the user to enter the student's ID, course information (department, course code, credit, and grade) one by one.
The user can stop entering grades by pressing the EOF indicator.
The method then prints the transcript of the student whose grades have been entered.

takeInputFromFile(): This method takes input from a text file to create a student transcript. The text file should 
contain information about courses taken by a student, with the following format:

120122

CENG 201 5 3.5

MATH 200 3 2.5

ECE 121 5 2.2


---

## Installation

Import the project classes.
> [https://github.com/aslihanhasar/Allianz-Java-Projects.git](https://github.com/aslihanhasar/Allianz-Java-Projects.git)

---

## Usage

* After cloning the project, open it with the ide you used.
* Create a CourseGrade object, providing the necessary details.
* Create a Transcript object for the student, passing the ID as an argument.
* Add each CourseGrade object to the Transcript object using the addCourseTaken() method.
* Print the student's transcript using the toString() method of the Transcript class.

###### It is represented in Main class.

---

## Author

**Aslıhan Hasar**

* GitHub: [aslihanhasar](https://github.com/aslihanhasar)
* LinkedIn: [aslıhanhasar](https://www.linkedin.com/in/asl%C4%B1hanhasar
  )

---

## Contributing

Contributions, issues, and feature requests are welcome.

---

## License

[MIT](https://choosealicense.com/licenses/mit/)

---

## Show Your Suport

Give me a &#11088; if you like the project.

---

## Acknowledgments

* This repo is created for assignments at Allianz & Patika.dev.


