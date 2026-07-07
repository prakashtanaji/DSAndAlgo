def trappingRainWater(height):
    if not height: return 0

    left, right = 0, len(height) -1
    left_max, right_max = height[left], height[right]

    total_water = 0

    while left < right:
        if left_max < right_max:
            left +=1
            if height[left] > left_max:
                left_max = height[left]
            else:
                total_water += left_max - height[left]
        else:
            right -=1
            if height[right] > right_max:
                right_max = height[right]
            else:
                total_water += right_max - height[right]

    return total_water

def trappingRainWater2(height):
    if not height: return 0

    left, right = 0, len(height) -1
    left_max, right_max = height[left], height[right]

    total_water = 0

    while left < right:
        if left_max < right_max:

            total_water += left_max;
            left +=1
            if height[left] > left_max:
                left_max = height[left]
        else:
            total_water += right_max;
            right -=1
            if height[right] > right_max:
                right_max = height[right]

    return total_water

print(trappingRainWater2([0,1,0,2,1,0,1,3,2,1,2,1]))