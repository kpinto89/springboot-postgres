CREATE EXTENSION IF NOT EXISTS pgcrypto;

CREATE OR REPLACE FUNCTION encrypt_client(plain_data TEXT, application_user_id_key UUID)
RETURNS TEXT AS $$
DECLARE
    encrypted_text BYTEA;
    encryption_key TEXT;
BEGIN
    -- Encrypt the client_data using the application_user_id_key as the encryption key
    encrypted_text := pgp_sym_encrypt(plain_data, application_user_id_key::text);

    RETURN encrypted_text::text;
END;
$$ LANGUAGE plpgsql;

CREATE OR REPLACE FUNCTION decrypt_client(encrypted_text TEXT, application_user_id_key UUID)
RETURNS TEXT AS $$
DECLARE
    decrypted_text TEXT;
BEGIN
    -- Decrypt the client_id and client_secret using pgcrypto's symmetric decryption
    decrypted_text := pgp_sym_decrypt(encrypted_text::bytea, application_user_id_key::text);
    RETURN decrypted_text::text;
END;
$$ LANGUAGE plpgsql;
