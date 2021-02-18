import { MigrationInterface, QueryRunner, Table } from 'typeorm';

export default class AdicionarVeiculos1613654214456 implements MigrationInterface {

    public async up(queryRunner: QueryRunner): Promise<void> {
        await queryRunner.createTable(
            new Table({
                name: 'veiculos',
                columns: [
                {
                    name: 'id',
                    type: 'varchar',
                    isPrimary: true,
                    generationStrategy: 'uuid',
                    default: 'uuid_generate_v4()',
                },
                {
                    name: 'modelo',
                    type: 'varchar',
                    isNullable: false,
                },
                {
                    name: 'marca',
                    type: 'varchar',
                    isNullable: false,
                },
                {
                    name: 'ano',
                    type: 'int',
                    isNullable: false,
                },
                {
                    name: 'descricao',
                    type: 'varchar',
                    isNullable: false,
                },
                {
                    name: 'vendido',
                    type: 'boolean',
                    isNullable: false,
                },
                {
                    name: 'created',
                    type: 'timestamp with time zone',
                    isNullable: false,
                },
                {
                    name: 'updated',
                    type: 'timestamp with time zone',
                    isNullable: false,
                },
                ],
            }),
        );
    }

    public async down(queryRunner: QueryRunner): Promise<void> {
        await queryRunner.dropTable('veiculos');
    }

}
