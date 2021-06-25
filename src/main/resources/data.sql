DROP TABLE IF EXISTS notes;

CREATE TABLE notes (
  id INT AUTO_INCREMENT  PRIMARY KEY,
  user_name VARCHAR(250) NOT NULL,
  note VARCHAR(250) DEFAULT NULL
);

INSERT INTO notes (user_name, note) VALUES
  ('Jesús', 'HTML es un lenguaje de marcado'),
  ('Jesús', 'CSS: estilos de presentación'),
  ('José', 'Haskell es Erlang con sintaxis amigable'),
  ('José', 'Elixir es un lenguaje funcional y académico'),
  ('Manuel', 'DB2 es un gran lenguaje de base de datos'),
  ('Manuel', 'Cobol es mi lenguaje favorito');
