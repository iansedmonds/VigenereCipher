# VigenereCipher
# NOTE: Originally this is from 2020. Locked out of my old github so transferring to new repo.

Program takes in 2 files, a key and a message, up to 512-bytes and encrypts the message using they provided key. C++ program and Java program provided.

C++ version ran from terminal using the following commands:
  - Build project: g++ vigenere.cpp -o vigenere (or name it anything else you want if no name is given then default is ./a.out)
  - Run project: ./vigenere [key text file] [message text file]
      EX: ./vigenere k0.txt p0.txt

Java version ran from terminal using the following commands:
  - Build project: javac vigenere.java (should create a vigenere.class file this is what is ran)
  - Run project: java vigenere [key text file] [message text file]
      EX: java vigenere k0.txt p0.txt

When providing key and message files, make sure they are in the same directory as the project.

Expected outputs are provided:
  key0.txt and message0.txt --> correctOutputk0m0.txt
  key1.txt and message1.txt --> correctOutputk1m1.txt
  key2.txt and message2.txt --> correctOutputk2m2.txt
  key3.txt and message3.txt --> correctOutputk3m3.txt
  key4.txt and message4.txt --> correctOutputk4m4.txt


If the message file to be encrypted doesn't have the proper number (512) of alphabetic characters, the last block is padded as necessary with the letter 'x'. Both files will be stripped of nonalphabetic characters and turned lowercase.
