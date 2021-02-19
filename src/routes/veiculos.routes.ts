import 'reflect-metadata';

import { request, response, Router } from 'express';
import { getCustomRepository } from 'typeorm';

import VeiculosRepository from '../repositories/VeiculosRepository';

import AdicionarVeiculoService from '../services/AdicionarVeiculoService';
import EncontrarVeiculoService from '../services/EncontrarVeiculoService';

const veiculosRouter = Router();

veiculosRouter.get('/', async (request, response) => {
  try{
    const veiculosRepository = getCustomRepository(VeiculosRepository);
    const veiculos = await veiculosRepository.find();
    return response.json(veiculos);
  } catch (err) {
    return response.status(400).json({ error: err.message });
  }
});

veiculosRouter.get('/find', async (request, response) => {
  try {
    const encontrarVeiculoService = new EncontrarVeiculoService();
    const query = request.query;
    //const { vendidos as boolean, decada, fabricante, ultimaSemana } = query;

    const vendidos: boolean = query.vendidos as unknown as boolean;
    const decada: number = query.decada as unknown as number;
    const fabricante: string = query.fabricante as unknown as string;
    const ultimaSemana: boolean = query.ultimaSemana as unknown as boolean;

    const veiculos = await encontrarVeiculoService.execute({ vendidos, decada, fabricante, ultimaSemana });
    return response.json(veiculos);
  } catch (err) {
    return response.status(400).json({ error: err.message });
  }
});

veiculosRouter.get('/:id', async (request, response) => {
  try{
    const veiculosRepository = getCustomRepository(VeiculosRepository);
    const { id } = request.params;
    const veiculos = await veiculosRepository.findOne(id);
    return response.json(veiculos);
  } catch (err) {
    return response.status(400).json({ error: err.message });
  }
});

veiculosRouter.put('/:id', async (request, response) => {
  try {
    const veiculosRepository = getCustomRepository(VeiculosRepository);
    const {id} = request.params;
    const {
      modelo,
      marca,
      ano,
      descricao,
      vendido,
      created,
    } = request.body;
    const updated = new Date();
    const veiculos = await veiculosRepository.save({
      id,
      modelo,
      marca,
      ano,
      descricao,
      vendido,
      created,
      updated
    });
    return response.json(veiculos);
  } catch (err) {
    return response.status(400).json({ error: err.message });
  }
});

veiculosRouter.patch('/:id', async (request, response) => {
  try {
    const veiculosRepository = getCustomRepository(VeiculosRepository);
    const {id} = request.params;
    const updated = new Date();
    request.body["updated"] = updated;
    const veiculos = await veiculosRepository.update(id, request.body);
    return response.json(veiculos);
  } catch (err) {
    return response.status(400).json({ error: err.message });
  }
});

veiculosRouter.post('/', async (request, response) => {
  try {
    const {
      modelo,
      marca,
      ano,
      descricao,
      vendido,
    } = request.body;

    const adicionarVeiculo = new AdicionarVeiculoService();

    const veiculo = await adicionarVeiculo.execute({
      modelo,
      marca,
      ano,
      descricao,
      vendido,
      created: new Date(),
      updated: new Date(),
    });

    return response.json(veiculo);
  } catch (err) {
    return response.status(400).json({ error: err.message });
  }
});

veiculosRouter.delete('/:id', async (request, response) => {
  try {
    const veiculosRepository = getCustomRepository(VeiculosRepository);
    const { id } = request.params;
    const resultado = await veiculosRepository.delete(id);
    return response.json(resultado);
  } catch (err) {
    return response.status(400).json({ error: err.message });
  }
});

export default veiculosRouter;
