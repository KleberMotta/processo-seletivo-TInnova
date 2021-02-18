import { Router } from 'express';
import veiculosRouter from './veiculos.routes';

const routes = Router();

routes.use('/veiculos', veiculosRouter);

export default routes;
