import axios from 'axios';
import { PublicApiService } from '../src/backend/services/publicApiService';

const fetchPublicApiData = async () => {
    const publicApiService = new PublicApiService();
    try {
        const data = await publicApiService.fetchAuctionData();
        console.log('Fetched data from public API:', data);
        // Here you can add logic to update the local database with the fetched data
    } catch (error) {
        console.error('Error fetching data from public API:', error);
    }
};

fetchPublicApiData();