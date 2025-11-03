import React from 'react';
import { render, screen } from '@testing-library/react';
import BidList from '../../frontend/pages/BidList';
import { MockedProvider } from '@apollo/client/testing';
import { GET_BIDS } from '../../frontend/graphql/queries';

const mocks = [
  {
    request: {
      query: GET_BIDS,
    },
    result: {
      data: {
        bids: [
          {
            id: '1',
            title: 'Bid 1',
            description: 'Description for Bid 1',
            price: 100,
          },
          {
            id: '2',
            title: 'Bid 2',
            description: 'Description for Bid 2',
            price: 200,
          },
        ],
      },
    },
  },
];

describe('BidList Component', () => {
  test('renders bid list correctly', async () => {
    render(
      <MockedProvider mocks={mocks} addTypename={false}>
        <BidList />
      </MockedProvider>
    );

    const bid1 = await screen.findByText('Bid 1');
    const bid2 = await screen.findByText('Bid 2');

    expect(bid1).toBeInTheDocument();
    expect(bid2).toBeInTheDocument();
  });

  test('displays loading state initially', () => {
    render(
      <MockedProvider mocks={[]} addTypename={false}>
        <BidList />
      </MockedProvider>
    );

    expect(screen.getByText(/loading/i)).toBeInTheDocument();
  });

  test('handles error state', async () => {
    const errorMocks = [
      {
        request: {
          query: GET_BIDS,
        },
        error: new Error('An error occurred'),
      },
    ];

    render(
      <MockedProvider mocks={errorMocks} addTypename={false}>
        <BidList />
      </MockedProvider>
    );

    const errorMessage = await screen.findByText(/an error occurred/i);
    expect(errorMessage).toBeInTheDocument();
  });
});