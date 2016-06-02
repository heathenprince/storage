import os # Don't worry about this

# MergeSort

# Sort Function
# Returns sorted version of List
# Leaves Original Intact
def sort(L):
    if ( len(L) > 1 ): # Start Splitting / Merging if len(L) > 1 (Which makes sense :) )
        # The "Divider" of the original list (halfway point)
        divider = len(L) / 2

        left = L[:divider]  # Left Sublist
        right = L[divider:] # Right Sublist

        # Sort the two Lists
        left = sort(left)
        right = sort(right)

        # Merge Them Together
        L = merge(left, right)

        return L
    else: # if len(L) <= 1, just return the list (which also makes sense :) )
        return L

# Merge Function
def merge(a, b):
    # Result Variable (Self-Explanatory)
    result = []

    # If Neither of Them Are Empty
    # Compare left's index 0 with right's index 0
    # Whichever is smaller, append that to the result and remove it
    # from its corresponding list
    while ( (len(a) > 0) and (len(b) > 0) ):
        if ( a[0] < b[0] ):
            result.append( a.pop(0) )
        else:
            result.append( b.pop(0) )

    # Append the leftovers (sadly, not food :'( )
    if ( len(a) > 0 ):
        result.extend(a)
    else:
        result.extend(b)

    return result

# Main Function
def main():
    # Test List
    nums = []

    # Append 25 random integers from 0-99 inclusive
    # To the Test List (nums)
    i = 0
    while i < 25:
        nums.append( rand_num() )
        i += 1

    # Test Thy Funcions! :)
    print "Original:", nums
    print "Sorted:", sort(nums)
    print "Unchanged:", nums

# DON'T WORRY ABOUT THIS FUNCTION!!!
# Rand Num Function
# Returns a Random Integer between 0 and 99 inclusive
def rand_num():
    return int( os.urandom(4).encode('hex'), 16 ) % 100

# Run Main Function
main()
