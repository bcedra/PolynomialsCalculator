# PolynomialsCalculator

## Description
Reads 2 polynomials and calculates the following operations between them: +,-,/,* and calculates derived and integral for both.

Input type: anX^n + an-1X^(n-1) + ... + a1X + a0

Communication between the user and the computer is done through the graphical interface. The input data entered by the user are the two polynomials. They will be interpreted as String. From that string, using REGEX, we need to remove the coefficient and grade of each monomial. Next, all operations will be done on those monomials. After the user has entered the input data, he will press the CALCULATE button and all the results of the operations will be displayed in the interface.

Polynomial: String -> ArrayList of Monomial
