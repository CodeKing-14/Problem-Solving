# Bob has a playlist of 
#  songs, each song has a singer associated with it (denoted by an integer)

# Favourite singer of Bob is the one whose songs are the most on the playlist

# Count the number of Favourite Singers of Bob

# Input Format

# The first line contains an integer 
# , denoting the number of songs in Bob's playlist.

# The following input contains 
#  integers, 
#  integer denoting the singer of the 
#  song.

# Output Format

# Output a single integer, the number of favourite singers of Bob

# Note: Use 64 bit data type

# Examples
# Input

# 5
# 1 1 2 2 4
# Output

# 2

# Brute Force Approach:

number = int(input())
singers = list(map(int, input().split()))

count_dict = {}

for singer in singers:
    if singer in count_dict:
        count_dict[singer] += 1
    else:
        count_dict[singer] = 1

max_count = max(count_dict.values())
favourite_singers_count = sum(1 for count in count_dict.values() if count == max_count)
print(favourite_singers_count)