Walidacja podanego stringa 

- URL

   /validate?stringToValidate
   
- Metoda
    
    GET
    
- Paramtery URL

    Wymagane:
    
    stringToValidate = [String]
    
    Podajemy stringa, którego chcemy zwalidować pod zawartości.
    
- Odpowiedzi:

    - Jeśli string złożony jest z samych liczb:
        {"structure": "Numeric"}
    
    - Jeśli string złożony jest z liczb oraz liter:
        {"structure": "Mixed letters and numbers"}
        
    - Jeśli string złożony jest z samych małych liter:
        {"structure": "LowerCase"}

    - Jeśli string zawiera znaki alfanumeryczne:        
        {"structure": "Contains alphanumeric"}
        
    - Jeśli string złożony jest z samych dużych liter:
        {"structure": "UpperCase"}

    - Jeśli string złożony jest z małych oraz dużych liter:        
        {"structure": "MixedCase"}
