#include <iostream>
#include <fstream>
#include <string>
#include <sstream>
#define MAX 512

//strip away all non-letters
std::string strip(std::string str) {
    
    std::string outStr;

    for(int i = 0; i < str.length(); i++) {    
        //strip down to just letters
        if( (str.at(i) >= 'A' && str.at(i) <= 'Z') ||
             (str.at(i) >= 'a' && str.at(i) <= 'z'))
        {
            outStr += str.at(i);
        }
    }

    return outStr;
}

//any uppercase to lowercase letters
std::string toLower(std::string str) {
    std::string outStr;

    for(int i = 0; i < str.size(); i++) {
        if(str.at(i) >= 'A' && str.at(i) <= 'Z')
            outStr += (str.at(i) + 32);
        else
            outStr += str.at(i);
    }

    return outStr;
}

//concatenate x's onto file contents
std::string xify(std::string str) {

    if(str.length() > MAX)
        return str.substr(0, MAX);

    while(str.length() < MAX) {
        str += 'x';
    }
    
    return str;
}

//prints only 80 characters per line
void printEighty(std::string str) {

    for(int i = 0; i < str.length(); i++) {
        std::cout << str.at(i);
        if( (i + 1 ) % 80 == 0 )
            std::cout << std::endl;
    }

    std::cout << std::endl << std::endl;
}

//uses corresponding letters to make cipher
void encrypt(const std::string k, const std::string p) {
    std::string cipher = "";

    //a = 0, b = 1, c = 2 ...
    for(int i = 0; i < MAX; i++) {
                //characters ascii values have 'a' ascii value (97) subtracted
                //from their value and then mod 26 to give the number corresponding
                //to the alphabet. Then 'a' is added back in order to find the correct
                //ascii value associated with that letter
        cipher += ( (k.at(i) - 'a') + (p.at(i) - 'a') ) % 26 + 'a';
    }

    std::cout << "\nCiphertext:\n";
    printEighty(cipher);

}

//pass by command line ->  argument 2: key text and argument 3: plain text
int main(int argc, char *argv[]) {

    //establish appropriate files and strings associated
    std::ifstream kFile, pFile;

    if(argc != 3) {
        std::cout << "Invalid amount of arguments\n";
        exit(EXIT_FAILURE);
    }

    //increment argument to make it equal to key and plain name    
    //open files
    argv++;
    kFile.open(*argv);
    argv++;
    pFile.open(*argv);

    std::string key = "", plaintext = "";

    //check if file is valid
    if(kFile.is_open() && kFile.good() && 
        pFile.is_open() && pFile.good());

    else {
        std::cerr << "Error opening key" << std::endl;
        exit(EXIT_FAILURE);
    }

    std::string temp;

    //read key file contents into string
    //and close file
    while( kFile >> temp) {
        key += temp;
    }
    kFile.close(); 

    //clear string
    temp.clear();

    //read plaintext file content into string
    //and close file
    while( pFile >> temp) {
        plaintext += temp;
    }
    pFile.close();

    //strip and to lower case key
    key = strip(key);
    key = toLower(key);

    //strip and to lower case plaintext
    //append x's if lower than 512 length
    plaintext = strip(plaintext);
    plaintext = toLower(plaintext);
    plaintext = xify(plaintext);

    //print unmodified key and plaintext
    std::cout << "\nKey:\n";
    printEighty(key);
    std::cout << "\nPlaintext:\n";
    printEighty(plaintext);

    //repeat key until 512 characters
    while (key.length() < MAX){
        key += key.substr(0,key.length());
    }
    key = key.substr(0, MAX);

    encrypt(key, plaintext);

    return 0;
}
