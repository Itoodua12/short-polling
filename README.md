# Short Polling (Backend communication Design Pattern)


## This project is a simple implementation of a short-polling mechanism for job submission and status checking.
## It is a RESTful API built with Spring Boot, using the @RestController annotation to handle HTTP requests.
## The primary functionality revolves around submitting jobs and checking their status.

# Endpoints
## Submit Job:

Endpoint: POST /submit
Description: Submits a new job, generates a unique job ID, and initializes the job progress to 0%.
Response: Returns the generated job ID.

## Check Job Status:

Endpoint: GET /checkstatus/{jobId}
Description: Checks the status of a submitted job based on the provided job ID.
Response: Returns the job status as a percentage.
Job Processing
The PollController class maintains a Map<String, Integer> called jobs to store job IDs and their corresponding progress percentages.
When a new job is submitted, a unique job ID is generated, the job is added to the map with an initial progress of 0%, and the job update process is initiated.

The updateJob method simulates a job processing scenario. It updates the job progress every 3 seconds until the progress reaches 100%.
It uses a separate thread to simulate asynchronous processing.