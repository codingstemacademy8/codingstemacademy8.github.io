#include <iostream>     // std::cin, std::cout
#include <fstream>      // std::ifstream

int main () {

  std::ifstream is("agram.in");     // open file

  char c;
  while (is.get(c))          // loop getting single characters
    {
    std::cout << c;
    }
  is.close();                // close file

  return 0;
}
