#include <iostream>     // std::cin, std::cout
#include <fstream>      // std::ifstream

int main () {
  char letters[26] = {'A','B','C','D','E','F','G','H','I','J','K','L','M','N','O','P','Q','R','S','T','U','V','W','X','Y','Z'};

  int tmp=0;

  std::ifstream is("agram.in");
  std::ofstream os("agram.out");

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
            os << letters[tmp] << " ";
        }
        if (c == 'B')
        {
            tmp = tmp+(2*2);
            os << letters[tmp] << " ";
        }
        if (c == 'C')
        {
            tmp = tmp+(3*2);
            os << letters[tmp] << " ";
        }

        if (c == '$')
        {
            os << "\n";
        }
    }
  os.close();                // close file
  is.close();                // close file

  return 0;
}
