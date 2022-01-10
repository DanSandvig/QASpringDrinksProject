# QASpringDrinksProject

## Why Are We Doing This?
<details>
<summary>"Click to expand"</summary>
This project will assess our ability to build a basic backend java service using Spring Boot to program an API with CRUD functionality.  

The program will perform operations on a MySql database in response to http requests to demonstrate our understanding of, and ability to direct, the flow of data in a manner similar to production software.  

We will also be demonstrating our wider understanding of software design through detailed project management, effective source control, thorough testing, and appropriate documentation.
</details>

## How I Expected The Challenge To Go
<details>
<summary>"Click to expand"</summary>
Thanks to what we had been taught during the course I was reasonably confident of getting the functionality of the program working - my main concerns in terms of time and complexity were the project management and testing aspects.
</details>

## What Went Well/What Didn't Go As Planned?
<details>
<summary>"Click to expand"</summary>
As I expected setting up Jira and writing the Unit and Integration tests took up the majority of time spent on the project.  

I had assumed that as MoSCoW and Acceptance Criteria seemed to standard practice they would be a default part of Jira so I hadn't counted on having to learn how to set them up myself, but once I understood a bit more on how to customize Jira it was relatively straightforward.  

Writing the unit tests took me a bit of time to get into the right mindset, there were a couple of methods I initially struggled to work out how to test, but in the end I got them all done and achieved over 95% coverage so I was pleased with that.

I was pleased and relieved when all my CRUD tests with Postman worked first time, for all I had completed all the unit and integration tests I'm still not experienced enough to "trust the process" and was convinced something would still go wrong the first time I ran the app.
</details>

## Possible Improvements For Future Revisions Of The Project
<details>
<summary>"Click to expand"</summary>
As the program is designed to accept user input (in this case via http requests) the first thing I would look to implement would be more extensive validation and exception handling, ideally with detailed feedback to the user of the problem with the data they submitted and suggestions to correct it where possible.

Even more ideal would be the creation of a front end, both to provide a user interface to submit requests rather than using postman, and also to carry out some of the data validation at source, rather than allowing invalid data to be submitted to the API in the first place.

For myself, one of the (many, many) things I will be looking to expand my knowledge on in the future is Regular Expressions so I can understand how to perform more detailed data validation, but I will also be learning more about Docker and Kubernetes so I can start to understand how I might deploy a similar project as a serverless web app.
</details>
## Screenshots Of Postman Requests And API Output
<details>
<summary>"Click to expand"</summary>  
![Postman Create Request]
![Postman Get All Request]
![Postman Get By Id Request]
![Postman Get By Name Request]
![Postman Update Request]
![Postman Delete Request]
</details>
## Screenshot Of Database To Show Data Persistence
<details>
<summary>"Click to expand"</summary>  
![MySql Database]
</details>
## Screenshot Of Test And Coverage Result
<details>
<summary>"Click to expand"</summary>  
![JUnit5 Tests And Coverage]
</details>
## Link To Jira Board
[Jira board for project](https://superqaadventureforce.atlassian.net/jira/software/projects/DRI/boards/3)
