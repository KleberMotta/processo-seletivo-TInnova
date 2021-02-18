import FakeVeiculosRepository from '../repositories/FakeVeiculosRepository';
import data from '../resources/vehiclesBrands.json';

// Os testes unitários não estão funcionais para as classes de serviço porque a inversão
// de dependência de conexão com o banco ainda não foi implementada
// Dessa forma não é possível chamar o código real do Service sem que haja
// Conexão com o banco
//
// Esses teste foi criado apenas para ilustar o funcionando dos testes unitários
describe('AdicionarVeiculos', () => {

    it('Deve ser capaz de validar o nome da Marca', async () =>{
          const fakeVeiculosRepository = new FakeVeiculosRepository();

          fakeVeiculosRepository.create({     
              id: 'mock',
              modelo: 'SLK 500}', 
              marca: 'Mercedes-Benz', 
              ano: 2005, 
              descricao: 'Usado mais conservado!',
              vendido: false,
              created: new Date(),
              updated: new Date(),
          });
        
          const veiculo = fakeVeiculosRepository.findByQuery();

          expect(
            data.find(item => veiculo.marca == item.brand),
          ).rejects.toBeFalsy;
    });

});