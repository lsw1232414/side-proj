# Onbid Kamco Auction Project

This project is a web application that utilizes public APIs to provide a comprehensive auction bidding service. It allows users to view auction items, manage their bids, and integrate with a purchasing system after winning bids.

## Features

- **Bid Information Integration**: Users can view a consolidated list of available bids from the public API.
- **Detailed Bid Information**: Users can access detailed information about specific bids, including descriptions, starting prices, and deadlines.
- **Favorites Management**: Users can manage their favorite bids, allowing them to easily track items of interest.
- **Post-Bid Integration**: The application integrates with a purchasing system to facilitate the buying process after a successful bid.

## Project Structure

```
onbid-kamco-auction
├── src
│   ├── backend
│   │   ├── app.ts
│   │   ├── controllers
│   │   │   ├── bidController.ts
│   │   │   └── favoriteController.ts
│   │   ├── routes
│   │   │   └── index.ts
│   │   ├── services
│   │   │   ├── bidService.ts
│   │   │   ├── favoriteService.ts
│   │   │   └── publicApiService.ts
│   │   ├── repositories
│   │   │   └── bidRepository.ts
│   │   ├── models
│   │   │   └── bid.model.ts
│   │   ├── integrations
│   │   │   └── purchaseIntegration.ts
│   │   ├── jobs
│   │   │   └── syncPublicApiJob.ts
│   │   └── types
│   │       └── index.ts
│   ├── frontend
│   │   ├── pages
│   │   │   ├── Home.tsx
│   │   │   ├── BidList.tsx
│   │   │   ├── BidDetail.tsx
│   │   │   └── Favorites.tsx
│   │   ├── components
│   │   │   ├── BidCard.tsx
│   │   │   ├── BidFilter.tsx
│   │   │   └── FavoriteButton.tsx
│   │   ├── hooks
│   │   │   └── useBids.ts
│   │   └── services
│   │       └── apiClient.ts
│   └── shared
│       ├── config
│       │   └── index.ts
│       └── types
│           └── index.ts
├── scripts
│   └── fetchPublicApi.ts
├── tests
│   ├── backend
│   │   └── bidService.test.ts
│   └── frontend
│       └── BidList.test.tsx
├── docs
│   └── api.md
├── package.json
├── tsconfig.json
├── .env.example
└── README.md
```

## Getting Started

1. Clone the repository:
   ```
   git clone <repository-url>
   ```

2. Navigate to the project directory:
   ```
   cd onbid-kamco-auction
   ```

3. Install dependencies:
   ```
   npm install
   ```

4. Set up environment variables by copying `.env.example` to `.env` and filling in the required values.

5. Start the application:
   ```
   npm start
   ```

## Contributing

Contributions are welcome! Please open an issue or submit a pull request for any improvements or bug fixes.

## License

This project is licensed under the MIT License. See the LICENSE file for details.