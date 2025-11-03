import express from 'express';
import { setRoutes } from './routes/index';
import { json, urlencoded } from 'body-parser';
import cors from 'cors';

const app = express();
const PORT = process.env.PORT || 3000;

app.use(cors());
app.use(json());
app.use(urlencoded({ extended: true }));

setRoutes(app);

app.listen(PORT, () => {
    console.log(`Server is running on http://localhost:${PORT}`);
});