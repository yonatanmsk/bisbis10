INSERT INTO task ( description, completed) VALUES
  ( 'description1', 'completed'),
  ('description2', 'completed');

-- INSERT INTO Restaurants (name, averageRating, isKosher, cuisines) VALUES
--     ('Taizu', 4.83, false, ARRAY['Asian','Mexican','Indian']);
--
-- CREATE TABLE Restaurants (
--      id SERIAL PRIMARY KEY,
--      name VARCHAR(255),
--      averageRating DOUBLE PRECISION,
--      isKosher BOOLEAN,
--      cuisines TEXT[]
-- );
--
-- SELECT table_name
-- FROM information_schema.tables
-- WHERE table_schema = 'public'
-- AND table_type = 'BASE TABLE';
--
-- DROP SCHEMA public CASCADE;
-- CREATE SCHEMA public;
--
-- SELECT table_name FROM information_schema.tables WHERE table_schema = 'public';

