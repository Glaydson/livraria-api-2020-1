insert into tb_editoras(editora_id, nome, cidade, ano_fundacao) values(1, 'Campus', 'Rio de Janeiro', 2000);
insert into tb_editoras(editora_id, nome, cidade, ano_fundacao) values(2, 'Saraiva', 'São Paulo', 1950);
insert into tb_editoras(editora_id, nome, cidade, ano_fundacao) values(3, 'Moderna', 'Rio de Janeiro', 1964);
insert into tb_editoras(editora_id, nome, cidade, ano_fundacao) values(4, 'Bookman', 'Florianópolis', 2002);
insert into tb_editoras(editora_id, nome, cidade, ano_fundacao) values(5, 'Atlas', 'Porto Alegre', 1994);
insert into tb_editoras(editora_id, nome, cidade, ano_fundacao) values(6, 'Pearson', 'São Paulo', 2010);

insert into tb_livros(livro_id, data_publicacao, numero_paginas, preco, titulo, editora_id) values (1, '1937-08-12', 250, 40.0, 'A Guerra dos Mundos', 3);
insert into tb_livros(livro_id, data_publicacao, numero_paginas, preco, titulo, editora_id) values (2, '1948-01-10', 1050, 100.0, 'Admirável Mundo Novo', 2);
insert into tb_livros(livro_id, data_publicacao, numero_paginas, preco, titulo, editora_id) values (3, '1999-11-01', 50, 49.50, 'Java Como Programar', 4);
insert into tb_livros(livro_id, data_publicacao, numero_paginas, preco, titulo, editora_id) values (4, '2010-10-05', 180, 130.0, 'Guerra e Paz', 1);
insert into tb_livros(livro_id, data_publicacao, numero_paginas, preco, titulo, editora_id) values (5, '2015-01-24', 145, 55.0, 'Manual de Contabilidade', 5);

insert into tb_autores(autor_id, nome, pais) values (1,'Orson Welles', 'Inglaterra');
insert into tb_autores(autor_id, nome, pais) values (2,'Aldous Huxley', 'Inglaterra');
insert into tb_autores(autor_id, nome, pais) values (3,'Leo Tolstoi', 'Rússia');
insert into tb_autores(autor_id, nome, pais) values (4,'Sérgio Iudicibus', 'Brasil');
insert into tb_autores(autor_id, nome, pais) values (5,'Harvey Deitel', 'Estados Unidos');
insert into tb_autores(autor_id, nome, pais) values (6,'Paul Deitel', 'Estados Unidos');

insert into tb_autores_livros(autores_autor_id, livros_livro_id) values (1, 5);
insert into tb_autores_livros(autores_autor_id, livros_livro_id) values (2, 3);
insert into tb_autores_livros(autores_autor_id, livros_livro_id) values (3, 4);
insert into tb_autores_livros(autores_autor_id, livros_livro_id) values (4, 5);
insert into tb_autores_livros(autores_autor_id, livros_livro_id) values (5, 3);
insert into tb_autores_livros(autores_autor_id, livros_livro_id) values (6, 3);
insert into tb_autores_livros(autores_autor_id, livros_livro_id) values (1, 4);
