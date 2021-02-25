const combinations = (elements) => {
    if (elements.length === 0) return [[]];

    const firstEL = elements[0];
    const rest = elements.slice(1);
    const combsWithoutFirst= combinations(rest);

    const combsWithFirst = [];

    combsWithoutFirst.forEach(comb => {
        const combWithFirst = [...comb, firstEL];
        combsWithFirst.push(combWithFirst);
    });

    return[... combsWithoutFirst, ...combsWithFirst]
}

combinations(['a', 'b', 'c']);

console.log(combinations(['c', 'b']))

/*
an array with three elements, has 8 combinations

[]
[a]
[b]
[c]
[a,b]
[b,c]
[a,c]
[a,b,c]

*/