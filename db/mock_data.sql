INSERT INTO ATTRIBUTE (id, code)
VALUES (1, 'supplierpacksize'),
       (2, 'helmetsize');

-- Insert labels for supplierpacksize
INSERT INTO ATTRIBUTE_LABELS (attribute_id, language, label)
VALUES (1, 'en_GB', 'Number in Package from Supplier'),
       (1, 'it_IT', 'Numero in confezioni dal fornitore');

-- Insert labels for helmetsize
INSERT INTO ATTRIBUTE_LABELS (attribute_id, language, label)
VALUES (2, 'en_GB', 'Helmet Sizes'),
       (2, 'it_IT', 'Tagliecasco');

INSERT INTO OPTION (id, attribute_id, code, sort_order)
VALUES (1, 2, '35mm', 0),
       (2, 2, '40mm', 1);

-- Insert labels for the 35mm option
INSERT INTO OPTION_LABELS (option_id, language, label)
VALUES (1, 'en_GB', '35 mm'),
       (1, 'it_IT', '35 mm');

-- Insert labels for the 40mm option
INSERT INTO OPTION_LABELS (option_id, language, label)
VALUES (2, 'en_GB', '40 mm'),
       (2, 'it_IT', '40 mm');

