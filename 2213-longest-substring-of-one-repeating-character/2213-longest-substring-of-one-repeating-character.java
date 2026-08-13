class Solution {

    class Node {
        char leftChar;
        char rightChar;

        int len;
        int prefix;
        int suffix;
        int best;

        Node(char leftChar, char rightChar,
             int len, int prefix, int suffix, int best) {

            this.leftChar = leftChar;
            this.rightChar = rightChar;
            this.len = len;
            this.prefix = prefix;
            this.suffix = suffix;
            this.best = best;
        }
    }

    Node[] tree;
    char[] s;

    public int[] longestRepeating(
        String str,
        String queryCharacters,
        int[] queryIndices
    ) {

        s = str.toCharArray();

        int n = s.length;

        tree = new Node[4 * n];

        build(1, 0, n - 1);

        int[] ans = new int[queryIndices.length];

        for (int i = 0; i < queryIndices.length; i++) {

            int index = queryIndices[i];

            char ch = queryCharacters.charAt(i);

            s[index] = ch;

            update(1, 0, n - 1, index, ch);

            ans[i] = tree[1].best;
        }

        return ans;
    }

    private void build(int node, int l, int r) {

        if (l == r) {

            tree[node] =
                new Node(s[l], s[l], 1, 1, 1, 1);

            return;
        }

        int mid = (l + r) / 2;

        build(node * 2, l, mid);

        build(node * 2 + 1, mid + 1, r);

        tree[node] = merge(
            tree[node * 2],
            tree[node * 2 + 1]
        );
    }

    private void update(
        int node,
        int l,
        int r,
        int index,
        char ch
    ) {

        if (l == r) {

            tree[node] =
                new Node(ch, ch, 1, 1, 1, 1);

            return;
        }

        int mid = (l + r) / 2;

        if (index <= mid) {

            update(node * 2, l, mid, index, ch);

        } else {

            update(node * 2 + 1, mid + 1, r, index, ch);
        }

        tree[node] = merge(
            tree[node * 2],
            tree[node * 2 + 1]
        );
    }

    private Node merge(Node a, Node b) {

        Node res = new Node(
            a.leftChar,
            b.rightChar,
            a.len + b.len,
            0,
            0,
            0
        );

        // Prefix
        res.prefix = a.prefix;

        if (a.prefix == a.len &&
            a.rightChar == b.leftChar) {

            res.prefix = a.len + b.prefix;
        }

        // Suffix
        res.suffix = b.suffix;

        if (b.suffix == b.len &&
            a.rightChar == b.leftChar) {

            res.suffix = b.len + a.suffix;
        }

        // Best
        res.best = Math.max(a.best, b.best);

        if (a.rightChar == b.leftChar) {

            res.best = Math.max(
                res.best,
                a.suffix + b.prefix
            );
        }

        return res;
    }
}