import { EntityRepository, Repository } from 'typeorm';

import Veiculo from '../models/veiculo';

@EntityRepository(Veiculo)
class VeiculosRepository extends Repository<Veiculo> {
  public async findByQuery(query: string): Promise<Array<Veiculo> | null> {
    const findVeiculo = await this.query(query);
    return findVeiculo || null; 
  }
}

export default VeiculosRepository;
