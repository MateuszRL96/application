CREATE TABLE plant_disease1 (
   id SERIAL PRIMARY KEY,
   name VARCHAR(255) NOT NULL,
   plant_id BIGINT,
   CONSTRAINT fk_plant
       FOREIGN KEY (plant_id)
           REFERENCES plant(id)
           ON DELETE CASCADE
);
