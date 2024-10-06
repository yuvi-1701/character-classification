# CharacterClassification Service

## Overview

The CharacterClassification Service is responsible for building and managing a hierarchical structure of character classes and subclasses. It exposes a GET endpoint to retrieve a nested structure of character classifications.

## Features

- **GET `/character-classes`**: Returns a nested structure of character classes and their respective subclasses, forming a parent-child relationship based on the data in the database.

## Setup

```bash
# 1. Clone the repository:
git clone <repository-url>
cd character-classification-service

# 2. Build the project:
mvn clean install

# 3. Run the application:
mvn spring-boot:run
```

## Endpoints
GET /character-classes
Returns a nested structure of character classes and their subclasses.
Example Response:
```bash
[
  {
    "Name": "Warrior",
    "Sub Classes": [
      {
        "Name": "Fighter"
      },
      {
        "Name": "Paladin"
      },
      {
        "Name": "Ranger"
      }
    ]
  },
  {
    "Name": "Wizard",
    "Sub Classes": [
      {
        "Name": "Mage"
      },
      {
        "Name": "Specialist wizard"
      }
    ]
  },
  {
    "Name": "Priest",
    "Sub Classes": [
      {
        "Name": "Cleric"
      },
      {
        "Name": "Druid"
      },
      {
        "Name": "Priest of specific mythos"
      }
    ]
  },
  {
    "Name": "Rogue",
    "Sub Classes": [
      {
        "Name": "Thief",
        "Sub Classes": [
          {
            "Name": "Assassin"
          }
        ]
      },
      {
        "Name": "Bard"
      }
    ]
  }
]
```
Curl Command
curl --location 'http://character-classification-service-4-env.eba-aqp6rdi8.ap-southeast-2.elasticbeanstalk.com/api/v1/character-classes'
