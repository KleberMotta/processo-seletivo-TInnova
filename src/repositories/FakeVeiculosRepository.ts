import Veiculo from '../models/veiculo';

class VeiculosRepository {

    private veiculo: Veiculo;

    public findByQuery(): Veiculo {
        return this.veiculo;
    }

    public create( {
        id,
        modelo,
        marca,
        ano,
        descricao,
        vendido,
        created,
        updated,
    }:Veiculo ) {
        
        const veiculo = new Veiculo();

        Object.assign(veiculo, {id, modelo, marca, ano, descricao, vendido, created, updated});

        this.veiculo = veiculo;

    };
}

export default VeiculosRepository;
