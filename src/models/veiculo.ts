import { Entity, Column, PrimaryGeneratedColumn } from 'typeorm';

@Entity('veiculos')
class Veiculo {
  @PrimaryGeneratedColumn('uuid')
  id: string;

  @Column()
  modelo: string;

  @Column()
  marca: string;

  @Column('numeric')
  ano: number;

  @Column('text')
  descricao: string;

  @Column('boolean')
  vendido: boolean;

  @Column('timestamp with time zone')
  created: Date;

  @Column('timestamp with time zone')
  updated: Date;
}

export default Veiculo;
