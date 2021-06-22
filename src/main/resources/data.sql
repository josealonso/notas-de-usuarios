DROP TABLE IF EXISTS notes;

CREATE TABLE notes (
  id INT AUTO_INCREMENT  PRIMARY KEY,
  user_name VARCHAR(250) NOT NULL,
  note_title VARCHAR(250) NOT NULL,
  note_text VARCHAR(250) DEFAULT NULL
);

INSERT INTO notes (user_name, note_title, note_text) VALUES
  ('Jesús', 'HTML', 'Lenguaje de marcado'),
  ('Jesús', 'CSS', 'Estilos de presentación'),
  ('José', 'Haskell', 'Es Erlang con sintaxis amigable'),
  ('José', 'Elixir', 'Lenguaje funcional y académico'),
  ('Manuel', 'DB2', 'Gran lenguaje de base de datos'),
  ('Manuel', 'Cobol', 'Mi lenguaje favorito');
