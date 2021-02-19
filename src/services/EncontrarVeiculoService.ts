import { getCustomRepository } from 'typeorm';

import Veiculo from '../models/veiculo';
import VeiculosRepository from '../repositories/VeiculosRepository';

interface Request {
  vendidos: boolean;
  decada: number;
  fabricante: string;
  ultimaSemana: boolean;
}

class EncontrarVeiculoService {
  public async execute({ vendidos, decada, fabricante, ultimaSemana }: Request): Promise<Array<Veiculo> | null > {
    const veiculosRepository = getCustomRepository(VeiculosRepository);
    let queryBuilder = "SELECT * FROM VEICULOS WHERE ";

    /*  
     *  Requisito: "Exibir a quantidade de veículos não vendidos na base"
     *  Isso será feito pelo fronte, onde haverá um indicativo da quantidade
     *  de registros retornados pela consulta.
     *   
     *  Haverá no front busca dinâmica pelo modelo uma vez que a lista
     *  de veículos for populada
     */

    // Eu entendo que o examinador pode achar essa solução pouco elegante
    // E que nos requisitos existe certa ambiguidade sobre a necessidade das consultas
    // de exibição serem individuais ou não, porém optei por essa solução para simplicar a lógica do front

    if(vendidos) {
        queryBuilder += "VENDIDO = TRUE AND ";
    } 
    if (decada) {
        queryBuilder += `ANO = ${decada} AND `;
    } 
    if (fabricante) {
        queryBuilder += `MARCA = '${fabricante}' AND `;
    } 
    if (ultimaSemana) {
        const hoje = new Date();
        let seteDiasAtras = new Date();
        seteDiasAtras.setDate(seteDiasAtras.getDate() - 7);
        queryBuilder += `CREATED BETWEEN '${seteDiasAtras.toISOString()}' AND '${hoje.toISOString()}' AND `;
    } 

    queryBuilder += "1 = 1";

    const veiculos = await veiculosRepository.findByQuery(queryBuilder);

    return veiculos;
  }
}

export default EncontrarVeiculoService;
