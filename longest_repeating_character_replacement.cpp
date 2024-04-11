#include <algorithm> // for std::max
#include <string>

class Solution {
public:
    int characterReplacement(const std::string& s, int k) {
        int maxLen = 0;
        int maxCount = 0;
        int i = 0;

        // Create an array to store the count of each character in the window
        int count[26] = {0};

        for (int j = 0; j < s.size(); ++j) {
            maxCount = std::max(maxCount, ++count[s[j] - 'A']);

            // If the window size minus the max count is greater than k,
            // move the window's left boundary to the right
            while (j - i + 1 - maxCount > k) {
                count[s[i] - 'A']--;
                ++i;
            }

            maxLen = std::max(maxLen, j - i + 1);
        }

        return maxLen;
    }
};
