import { getCustomRepository } from 'typeorm';
import data from '../resources/vehiclesBrands.json';
//import axios from 'axios';

import Veiculo from '../models/veiculo';
import VeiculosRepository from '../repositories/VeiculosRepository';

interface Request {
  modelo: string;
  marca: string;
  ano: number;
  descricao: string;
  vendido: boolean;
  created: Date;
  updated: Date;
}

class AdicionarVeiculoService {
  public async execute({ modelo, marca, ano, descricao, vendido, created, updated }: Request): Promise<Veiculo> {
    const veiculosRepository = getCustomRepository(VeiculosRepository);

    // Consulta API de carros - Em uma aplicação do mundo real em produção o processe seria semelhante a esse
    // Outra solução seria criar uma tabebla no banco e atualizá-la com um batch de tempos em tempos
    /* const data = await axios.get('https://the-vehicles-api.herokuapp.com/brands/').then(res => 
         res.data.brand  == marca
         ...
       );
    */

    const marcaExiste = data.find(elementos => elementos.brand == marca);

    if(!marcaExiste) {
      throw "Marca informada não existe";
    }

    const veiculo = veiculosRepository.create({
      modelo,
      marca,
      ano,
      descricao,
      vendido,
      created,
      updated,
    });

    await veiculosRepository.save(veiculo);

    return veiculo;
  }
}

export default AdicionarVeiculoService;
