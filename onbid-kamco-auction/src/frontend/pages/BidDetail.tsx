import React, { useEffect, useState } from 'react';
import { useParams } from 'react-router-dom';
import apiClient from '../services/apiClient';

const BidDetail = () => {
    const { bidId } = useParams();
    const [bidDetail, setBidDetail] = useState(null);
    const [loading, setLoading] = useState(true);
    const [error, setError] = useState(null);

    useEffect(() => {
        const fetchBidDetail = async () => {
            try {
                const response = await apiClient.get(`/bids/${bidId}`);
                setBidDetail(response.data);
            } catch (err) {
                setError('Failed to fetch bid details');
            } finally {
                setLoading(false);
            }
        };

        fetchBidDetail();
    }, [bidId]);

    if (loading) {
        return <div>Loading...</div>;
    }

    if (error) {
        return <div>{error}</div>;
    }

    return (
        <div>
            <h1>{bidDetail.title}</h1>
            <p>{bidDetail.description}</p>
            <p>Starting Price: {bidDetail.startingPrice}</p>
            <p>End Date: {new Date(bidDetail.endDate).toLocaleString()}</p>
            {/* Additional bid details can be displayed here */}
        </div>
    );
};

export default BidDetail;