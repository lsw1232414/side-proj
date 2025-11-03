# API Documentation for Onbid Kamco Auction

## Overview
The Onbid Kamco Auction project provides a comprehensive service for managing auction bids using public APIs. This documentation outlines the available API endpoints, their functionalities, and usage examples.

## Base URL
The base URL for all API requests is:
```
http://localhost:3000/api
```

## Endpoints

### 1. Bid Information

#### 1.1 Get All Bids
- **Endpoint:** `/bids`
- **Method:** GET
- **Description:** Retrieves a list of all available bids.
- **Response:**
  - **200 OK**
    ```json
    [
      {
        "id": "string",
        "title": "string",
        "description": "string",
        "startPrice": "number",
        "currentPrice": "number",
        "endDate": "string"
      }
    ]
    ```

#### 1.2 Get Bid Details
- **Endpoint:** `/bids/:id`
- **Method:** GET
- **Description:** Retrieves detailed information about a specific bid.
- **Parameters:**
  - `id`: The unique identifier of the bid.
- **Response:**
  - **200 OK**
    ```json
    {
      "id": "string",
      "title": "string",
      "description": "string",
      "startPrice": "number",
      "currentPrice": "number",
      "endDate": "string",
      "bidHistory": [
        {
          "bidder": "string",
          "amount": "number",
          "timestamp": "string"
        }
      ]
    }
    ```

### 2. Favorites Management

#### 2.1 Add to Favorites
- **Endpoint:** `/favorites`
- **Method:** POST
- **Description:** Adds a bid to the user's favorites.
- **Request Body:**
  ```json
  {
    "bidId": "string"
  }
  ```
- **Response:**
  - **201 Created**
    ```json
    {
      "message": "Bid added to favorites."
    }
    ```

#### 2.2 Get Favorite Bids
- **Endpoint:** `/favorites`
- **Method:** GET
- **Description:** Retrieves a list of the user's favorite bids.
- **Response:**
  - **200 OK**
    ```json
    [
      {
        "id": "string",
        "title": "string"
      }
    ]
    ```

#### 2.3 Remove from Favorites
- **Endpoint:** `/favorites/:id`
- **Method:** DELETE
- **Description:** Removes a bid from the user's favorites.
- **Parameters:**
  - `id`: The unique identifier of the bid.
- **Response:**
  - **204 No Content**

### 3. Purchase Integration

#### 3.1 Integrate Purchase
- **Endpoint:** `/purchase`
- **Method:** POST
- **Description:** Initiates the purchase process for a won bid.
- **Request Body:**
  ```json
  {
    "bidId": "string",
    "userId": "string"
  }
  ```
- **Response:**
  - **200 OK**
    ```json
    {
      "message": "Purchase initiated successfully."
    }
    ```

## Error Handling
All API responses include an error message in case of failure. Common error responses include:
- **400 Bad Request:** Invalid input data.
- **404 Not Found:** Resource not found.
- **500 Internal Server Error:** Unexpected server error.

## Conclusion
This API documentation provides a clear overview of the endpoints available in the Onbid Kamco Auction project. For further assistance, please refer to the project's README or contact the development team.