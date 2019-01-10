#include <iostream>     // std::cin, std::cout
#include <fstream>      // std::ifstream

int main () {
  char str[256];

  char letters[26] = {'A','B','C','D','E','F','G','H','I','J','K','L','M','N','O','P','Q','R','S','T','U','V','W','X','Y','Z'};


  int tmp=0;

  std::ifstream is("agram.in");     // open file

  char c;
  while (is.get(c))          // loop getting single characters
    {
        if (c == ',')
        {
            continue;
        }

        if (c == 'A')
        {
            tmp = tmp+(1*2);
            std::cout << letters[tmp] << " ";
        }
        if (c == 'B')
        {
            tmp = tmp+(2*2);
            std::cout << letters[tmp] << " ";
        }
        if (c == 'C')
        {
            tmp = tmp+(3*2);
            std::cout << letters[tmp] << " ";
        }

        if (c == '$')
        {
            std::cout << "\n";
        }
    }
  is.close();                // close file

  return 0;
}
