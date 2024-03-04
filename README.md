# Pierce Test Task for Cernev

## JSON Model

Below you can see example of JSON model

```json
{
  "attributes": [
    {
      "code": "supplierpacksize",
      "labels": {
        "label-it_IT": "Numero in confezioni dal fornitore",
        "label-en_GB": "Number in Package from Supplier",
        "label-en_IE": "Number in Package from Supplier",
        ...
      },
      "options": []
    },
    {
      "code": "helmetsize",
      "labels": {
        "label-it_IT": "Tagliecasco",
        "label-en_GB": "Helmet Sizes",
        "label-en_IE": "Helmet Sizes",
        ...
      },
      "options": [
        {
          "code": "35mm",
          "labels": {
            "label-es_ES": "35 mm",
            "label-nl_NL": "35 mm",
            "label-nl_BE": "35 mm",
            ...
          },
          "sort_order": 0
        },
        {
          "code": "40mm",
          "labels": {
            "label-es_ES": "40 mm",
            ...
          },
          "sort_order": 1
        },
        ...
      ]
    },
    ...
  ]
}

```

### Details

This JSON model is a representation of a product's attributes. Each attribute has a code, labels and options. The labels
are translations of the attribute's name in different languages. The options are the possible values for the attribute.
Each option has a code, labels and a sort order.
In the project I have created a REST API to manage this JSON model. I divided the attributes and options into two
separate entities and created a one-to-many relationship between them.

### Diagram

<img src=".\diagram.png" width="380"/>

## Running the Project

### Prerequisites

- Java JDK 17
- IntelliJ IDEA or any preferred IDE that supports Spring Boot

### Steps to Run

* You can run the application by running the `CernevTestTaskApplication` class in your IDE.

### Accessing the H2 Database Console

This project uses H2, an in-memory database, for storing and managing data:

- **URL**: `http://localhost:8080/h2-console`
- **JDBC URL**: `jdbc:h2:mem:testdb`
- **User Name**: `sa`
- **Password**: `password`

Be sure application is running before accessing the H2 console.

### Swagger (OpenAPI) Documentation

Swagger UI is integrated into the project to explore and test the REST APIs:

- **Access Swagger UI**: Navigate to `http://localhost:8080/swagger-ui.html` in your web browser to view the API
  documentation and interact with the APIs.


