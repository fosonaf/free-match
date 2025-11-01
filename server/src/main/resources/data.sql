-- Terrain
INSERT INTO fields (id, name, address, city, latitude, longitude)
SELECT 'f1f1f1f1-f1f1-f1f1-f1f1-f1f1f1f1f1f1', 'Lilas Park', '12 Lilas Street', 'Paris', 48.8584, 2.2945
    WHERE NOT EXISTS (SELECT 1 FROM fields WHERE id = 'f1f1f1f1-f1f1-f1f1-f1f1-f1f1f1f1f1f1');

-- Sports
INSERT INTO field_sports (field_id, sport)
SELECT 'f1f1f1f1-f1f1-f1f1-f1f1-f1f1f1f1f1f1', 'FOOT'
    WHERE NOT EXISTS (SELECT 1 FROM field_sports WHERE field_id = 'f1f1f1f1-f1f1-f1f1-f1f1-f1f1f1f1f1f1' AND sport = 'FOOT');

INSERT INTO field_sports (field_id, sport)
SELECT 'f1f1f1f1-f1f1-f1f1-f1f1-f1f1f1f1f1f1', 'BASKET'
    WHERE NOT EXISTS (SELECT 1 FROM field_sports WHERE field_id = 'f1f1f1f1-f1f1-f1f1-f1f1-f1f1f1f1f1f1' AND sport = 'BASKET');

-- Joueurs
INSERT INTO players (id, username, age, avatar_url)
SELECT 'a1a1a1a1-a1a1-a1a1-a1a1-a1a1a1a1a1a1', 'Zidane94', 30, 'https://api.dicebear.com/7.x/avataaars/svg?seed=Zidane94'
    WHERE NOT EXISTS (SELECT 1 FROM players WHERE id = 'a1a1a1a1-a1a1-a1a1-a1a1-a1a1a1a1a1a1');

INSERT INTO players (id, username, age, avatar_url)
SELECT 'b2b2b2b2-b2b2-b2b2-b2b2-b2b2b2b2b2b2', 'LeBron23', 28, 'https://api.dicebear.com/7.x/avataaars/svg?seed=LeBron23'
    WHERE NOT EXISTS (SELECT 1 FROM players WHERE id = 'b2b2b2b2-b2b2-b2b2-b2b2-b2b2b2b2b2b2');

-- Créneaux (toujours nouveaux grâce à RANDOM_UUID)
INSERT INTO slots (id, field_id, date, start_time, end_time, is_available)
SELECT RANDOM_UUID(), 'f1f1f1f1-f1f1-f1f1-f1f1-f1f1f1f1f1f1', '2025-11-05', '19:00:00', '20:30:00', true
    WHERE NOT EXISTS (
    SELECT 1 FROM slots
    WHERE field_id = 'f1f1f1f1-f1f1-f1f1-f1f1-f1f1f1f1f1f1'
      AND date = '2025-11-05'
      AND start_time = '19:00:00'
);

INSERT INTO slots (id, field_id, date, start_time, end_time, is_available)
SELECT RANDOM_UUID(), 'f1f1f1f1-f1f1-f1f1-f1f1-f1f1f1f1f1f1', '2025-11-05', '20:30:00', '22:00:00', true
    WHERE NOT EXISTS (
    SELECT 1 FROM slots
    WHERE field_id = 'f1f1f1f1-f1f1-f1f1-f1f1-f1f1f1f1f1f1'
      AND date = '2025-11-05'
      AND start_time = '20:30:00'
);