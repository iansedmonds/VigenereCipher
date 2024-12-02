# VigenereCipher
# NOTE: Originally this is from 2020. Locked out of my old github so transferring to new repo.
# Vigener cipher encrypts a message by using a designated key. Similar to a Ceasar Cipher that offsets a character by a value, a Vigenere cipher will offset a message character by the character given in the key.

Example: A = 0, B = 1, ... Z = 25 OR a = 0, b = 1, ... z = 25 (only lowercase is used, uppercase is converted to lower)
if message = "ab" and key = "xy" then ciphertext = "xz".

Program takes in 2 files, a key and a message, up to 512-bytes and encrypts the message using the provided key. C++ program and Java program provided.

C++ version ran from terminal using the following commands:
  - Build project: g++ vigenere.cpp -o vigenere (or name it anything else you want if no name is given then default is ./a.out)
  - Run project: ./vigenere [key text file] [message text file]
      EX: ./vigenere k0.txt p0.txt

Java version ran from terminal using the following commands:
  - Build project: javac vigenere.java (should create a vigenere.class file this is what is ran)
  - Run project: java vigenere [key text file] [message text file]
      EX: java vigenere k0.txt p0.txt

When providing key and message files, make sure they are in the same directory as the project. Programs can handle files containing larger than 512 bytes but will only use and encrypt the first 512 alphabetic bytes of the message using the first 512 alphabetic bytes of the key.

Expected outputs are provided in correctOutput.txt

If the message file to be encrypted doesn't have the proper number (512) of alphabetic characters, the last block is padded as necessary with the letter 'x'. Both files will be stripped of nonalphabetic characters and turned lowercase.
