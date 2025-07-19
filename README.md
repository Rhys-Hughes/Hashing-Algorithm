# Hashing-Algorithm
Simple hashing algorithm developed during time in university

------------------------------

While certainly not a secure hashing algorithm by any means, it was a fun experiment that taught me a lot about how hashing works on a granular level, why collisions happen, and why it is important to leave making hashing algorithms to the professionals, funnily enough.

This algorithm works simply, by taking the numeric value of each character, and using exponentiation to calculate a large number, as follows:

 - we iterate through the word, taking the numeric value of the current character, and exponentiate it by the previous value (if the value is the first, it uses the last)
 - the results of these are mutliplied together into a single total (in the code this is done continously via a total variable)
 - the final result is then encoded as the user requires, be it hex encoding, leaving it as a truncated integer, or converting it into raw bites

### here is an example:
------------------------------
word = "hello"

values -> 104, 101, 108, 108, 111

results of exponentiation -> (104 ^ 111), (101 ^ 104), (108 ^ 101), (108 ^ 108), (111 ^ 108)

these results are then multiplied together into a total -> (104 ^ 111) * (101 ^ 104) * (108 ^ 101) * (108 ^ 108) * (111 ^ 108)

the result would then be formatted accordingly via truncation and encoding / conversion into different bases as desired / required
