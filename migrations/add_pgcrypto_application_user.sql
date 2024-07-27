CREATE EXTENSION IF NOT EXISTS pgcrypto;

CREATE OR REPLACE FUNCTION encrypt_client(client_data TEXT, application_user_id_key UUID)
RETURNS TEXT AS $$
DECLARE
    encrypted_client_data TEXT;
BEGIN
    -- Encrypt the client_id and client_secret using the encryption_key
    encrypted_client_data := pgp_sym_encrypt(client_data, application_user_id_key::text);
    RETURN encrypted_client_data::text;
END;
$$ LANGUAGE plpgsql;

CREATE OR REPLACE FUNCTION decrypt_client(client_data TEXT, application_user_id_key UUID)
RETURNS TEXT AS $$
DECLARE
    decrypted_client_data TEXT;
BEGIN
    -- Decrypt the client_id and client_secret using pgcrypto's symmetric decryption
    decrypted_client_data := pgp_sym_decrypt(client_data, application_user_id_key::text);
    RETURN decrypted_client_data::text;
END;
$$ LANGUAGE plpgsql;
