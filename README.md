# M2-Challenge-Clarke-Mark

In this assessment, you will build a simple REST web service.

## Structure

Your solution must have the following structural elements:

- Your solution must be in an IntelliJ project called `M2-Challenge-Lastname-Firstname`.
- Your project must be built using Spring Boot. Initialize your project using `start.spring.io`.
- Your REST API must accept and return data in JSON format where appropriate.
- Every endpoint must have at least one MockMVC test. Endpoints that have error conditions must also contain a MockMVC test for each kind of error.
- Your REST API must be documented with Swagger. Save the `.yaml` file in the root of your project directory.

## Requirements/Features

This web service is a month-and-math service. You must implement and document the following REST API endpoints:

- Month Converter:
    - URI: /month/{monthNumber}
    - HTTP Method: GET
    - Request Body: None
    - Response Body: A Month Object containing the name and number of the requested month (1 - January, 2 - February, etc.)
    - Error: 422, if the input is out of range
- Random Month:
    - URI: /randomMonth
    - HTTP Method: GET
    - Request Body: None
    - Response Body: A Month Object containing a randomly selected month
- Add:
    - URI: /add
    - HTTP Method: POST
    - Request Body: JSON object with operand1 and operand2
    - Response Body: MathSolution, where answer is sum of operand1 and operand2
    - Error: 422, if missing operand or if operands are not both numbers
- Subtract:
    - URI: /subtract
    - HTTP Method: POST
    - Request Body: JSON object with operand1 and operand2
    - Response Body: MathSolution, where answer is difference of operand1 and operand2 (operand1 - operand2)
    - Error: 422, if missing operand or if operands are not both numbers
- Multiply:
    - URI: /multiply
    - HTTP Method: POST
    - Request Body: JSON object with operand1 and operand2
    - Response Body: MathSolution, where answer is product of operand1 and operand2
    - Error: 422, if missing operand or if operands are not both numbers
- Divide:
    - URI: /divide
    - HTTP Method: POST
    - Request Body: JSON object with operand1 and operand2
    - Response Body: MathSolution, where answer is quotient of operand1 and operand2 (operand1/operand2)
    - Error: 422, if missing operand or if operands are not both numbers, or if operand2 is zero

A Month has the following fields:
- number
- name

For example:
```javascript
{
  "number": 9,
  "name": "September"
}
```
A MathSolution has the following fields:
- operand1
- operand2
- operation (one of `add`, `subtract`, `multiply`, and `divide`)
- answer

For example:
```javascript
{
  "operand1": 10,
  "operand2": 20,
  "operation": "add",
  "answer": 30
}
```

All numeric fields for all endpoints (request and response) are integers.

## Submission

Great job completing your second Challenge! It’s time to submit. Follow the steps from your first Challenge submission, but customize the naming conventions for this particular assignment. Make sure to double-check that your submission is completed.

## Grading Requirements

### **General setup and format requirements: 10%**

1. Your solution must reside in an IntelliJ project called `M2-Challenge-Lastname-Firstname`. - **5%**
1. The REST API must be documented with Swagger. Save the `.yaml` file in the root of your project directory. - **5%**

### **Month Endpoint Code: 15%**

1. Code is clean (follows general patterns as presented in class) - **3%**
1. Month endpoint: - **3%**

    - URI: /month/{monthNumber}
    - HTTP Method: GET
    - Request Body: None
    - Response Body: A Month Object containing the name and number of the requested month (1 - January, 2 - February, etc.)
    - Error: 422, if the input is out of range

1. Month object members: - **3%**

    - number
    - name

1. MockMVC test for successful response - **3%**
1. MockMVC test for input out of range - **3%**

### **Random Month Endpoint Code: 15%**

1. Code is clean (follows general patterns as presented in class) - **3%**
1. Random Month endpoint: - **3%**

    - URI: /randomMonth
    - HTTP Method: GET
    - Request Body: None
    - Response Body: A Month Object containing a randomly selected month

1. Month object members: - **3%**

    - number
    - name

1. MockMVC test for successful response - **3%**
1. Months are served at random - **3%**

### **Add Endpoint Code: 15%**

1. Code is clean (follows general patterns as presented in class) - **3%**
1. Add endpoint: - **3%**

    - URI: /add
    - HTTP Method: POST
    - Request Body: JSON object with operand1 and operand2
    - Response Body: MathSolution, where answer is sum of operand1 and operand2
    - Error: 422, if missing operand or if operands are not both numbers

1. MathSolution object members: - **3%**

    - `operand1` - same value as `operand1` input
    - `operand2` - same value as `operand2` input
    - operation - `add`
    - answer - sum of `operand1` and `operand2`

1. MockMVC test for successful response - **3%**
1. MockMVC test for invalid request - **3%**

### **Subtract Endpoint Code: 15%**

1. Code is clean (follows general patterns as presented in class) - **3%**
1. Subtract endpoint: - **3%**

    - URI: /subtract
    - HTTP Method: POST
    - Request Body: JSON object with operand1 and operand2
    - Response Body: MathSolution, where answer is result of operand1 minus operand2
    - Error: 422, if missing operand or if operands are not both numbers

1. MathSolution object members: - **3%**

    - `operand1` - same value as `operand1` input
    - `operand2` - same value as `operand2` input
    - operation - `subtract`
    - answer - result of `operand1` minus `operand2`

1. MockMVC test for successful request - **3%**
1. MockMVC test for invalid request - **3%**

### **Multiply Endpoint Code: 15%**

1. Code is clean (follows general patterns as presented in class) - **3%**
1. Multiply endpoint: - **3%**

    - URI: /multiply
    - HTTP Method: POST
    - Request Body: JSON object with operand1 and operand2
    - Response Body: MathSolution, where answer is product of operand1 and operand2
    - Error: 422, if missing operand or if operands are not both numbers

1. MathSolution object members: - **3%**

    - `operand1` - same value as `operand1` input
    - `operand2` - same value as `operand2` input
    - operation - `multiply`
    - answer - product of `operand1` and `operand2`

1. MockMVC test for successful response - **3%**
1. MockMVC test for invalid request - **3%**

### **Divide Endpoint Code: 15%**

1. Code is clean (follows general patterns as presented in class) - **2%**
1. Divide endpoint: - **3%**

    - URI: /divide
    - HTTP Method: POST
    - Request Body: JSON object with operand1 and operand2
    - Response Body: MathSolution, where answer is result of operand1 divided by operand2
    - Error: 422, if missing operand or if operands are not both numbers

1. MathSolution object members: - **2%**

    - `operand1` - same value is `operand1` input
    - `operand2` - same value as `operand2` input
    - operation - `divide`
    - answer - integer result of `operand1` divided by `operand2`

1. MockMVC test for successful response - **2%**
1. MockMVC test for invalid request - **3%**
1. MockMVC test for divide-by-zero request - **3%**
