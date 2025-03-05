import pytest

@pytest.mark.parametrize(
    "a_list, output",
    [
        ([1, 10], ([1],[10])),
        ([10, 1], ([10],[1])),
        ([10, 1, 2], ([10],[1],[2]))
    ]
)
def test_merge(a_list, output):
    assert output == merge(a_list)

def merge(a_list):
    first_half = []
    second_half = []

    index = int(len(a_list)/ 2)
    for i in range(index):
        first_half.append(a_list[i])

    for i in range(index, len(a_list)):
        second_half.append(a_list[i])

    if len(first_half) > 1:
        merge(first_half)
    if len(second_half) > 1:
        merge(second_half)

    #sort_merge(first_half, second_half)

    return first_half, second_half

def sort_merge(first_half, second_half):
    if first_half[0] > second_half[0]:
        temp = first_half[0]
        first_half[0] = second_half[0]
        second_half[0] = temp
    else:
        return
    sort_merge(first_half, second_half)
