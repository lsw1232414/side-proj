import axios from 'axios';
import { API_BASE_URL } from '../../shared/config';

const apiClient = axios.create({
  baseURL: API_BASE_URL,
  timeout: 10000,
  headers: {
    'Content-Type': 'application/json',
  },
});

const apiClientService = {
  getBids: async () => {
    const response = await apiClient.get('/bids');
    return response.data;
  },
  getBidDetails: async (bidId) => {
    const response = await apiClient.get(`/bids/${bidId}`);
    return response.data;
  },
  getFavorites: async () => {
    const response = await apiClient.get('/favorites');
    return response.data;
  },
  addFavorite: async (bidId) => {
    const response = await apiClient.post('/favorites', { bidId });
    return response.data;
  },
  removeFavorite: async (bidId) => {
    const response = await apiClient.delete(`/favorites/${bidId}`);
    return response.data;
  },
};

export default apiClientService;